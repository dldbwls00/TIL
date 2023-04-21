import math, numpy
import OpenGL, ctypes

SCR_WIDTH = 600
SCR_HEIGHT = 600

vertexShaderSource = """
#version 330 core
layout (location = 0) in vec3 aPos;
layout (location = 1) in vec3 aColor;

uniform vec3 scale;
uniform vec3 trans;

out vec3 outColor;


void main(){
    vec3 nposition = aPos * scale + trans;
    gl_Position = vec4(nposition, 1.0);
    outColor = aColor;
}
"""

fragmentShaderSource = """
#version 330 core
out vec4 FragColor;
in vec3 outColor;

uniform int incase;

void main(){
    switch (incase){
        case 0:
            FragColor = vec4(outColor, 1.0f);
            break;
        case 1:
            FragColor = vec4(1.0f, 1.0f, 1.0f, 1.0f);
            break;
    }
}
"""

from glfw import (window_hint, init, create_window, terminate,
                  make_context_current, swap_buffers, poll_events,
                  window_should_close,
                  CONTEXT_VERSION_MAJOR,
                  CONTEXT_VERSION_MINOR, OPENGL_FORWARD_COMPAT,
                  OPENGL_PROFILE, OPENGL_CORE_PROFILE)

from OpenGL.GL import *

from OpenGL.GL.shaders import (GL_VERTEX_SHADER, GL_FRAGMENT_SHADER,
                               compileShader, glCreateProgram,
                               glAttachShader, glUseProgram, glGetUniformLocation, glUniform1f)


def main():
    # Initialize the library
    if not init():
        return

    window_hint(CONTEXT_VERSION_MAJOR, 3)
    window_hint(CONTEXT_VERSION_MINOR, 3)
    window_hint(OPENGL_FORWARD_COMPAT, GL_TRUE)
    window_hint(OPENGL_PROFILE, OPENGL_CORE_PROFILE)

    # program = glutils.loadShaders(vs_source, fs_source)
    # Create a windowed mode window and its OpenGL context
    window = create_window(SCR_WIDTH, SCR_HEIGHT, "Window Only", None, None)
    if not window:
        terminate()
        return

    # Make the window's context current
    make_context_current(window)

    shaderV = compileShader([vertexShaderSource], GL_VERTEX_SHADER)
    shaderF = compileShader([fragmentShaderSource], GL_FRAGMENT_SHADER)
    program = glCreateProgram()

    glAttachShader(program, shaderV)
    glAttachShader(program, shaderF)
    glLinkProgram(program)

    vao = glGenVertexArrays(1)
    glBindVertexArray(vao)
    vertexBuffer = glGenBuffers(1)
    glBindBuffer(GL_ARRAY_BUFFER, vertexBuffer)

    vertexData = numpy.array([], numpy.float32)
    npos = []
    last_pos = []
    triangle = []
    for x in range(40):
        posx = math.sin(x * math.pi / 40.0 * 2.0) * 0.8
        posy = math.cos(x * math.pi / 40.0 * 2.0) * 0.8
        npos = [posx, posy, 0.0, 0.0, 1.0 / 40 * x, 1.0 - 1.0 / 40 * x] #r=0, g, b

        if last_pos:
            triangle = [0.0, 0.0, 0.0, 0.0, 0.0, 0.0] + last_pos + npos
            vertexData = numpy.append(vertexData, numpy.array(triangle, numpy.float32))

        last_pos = npos

    triangle = [0.0, 0.0, 0.0, 0.0, 0.0, 0.0] + last_pos + list(vertexData[6 * 1:6 * 1 + 3]) + [0.0, 1.0, 0.0] ##g로 마무리
    vertexData = numpy.append(vertexData, numpy.array(triangle, numpy.float32))

    glBufferData(GL_ARRAY_BUFFER, 4 * len(vertexData), vertexData,
                 GL_STATIC_DRAW)
    # enable vertex array
    glEnableVertexAttribArray(0)

    ## position of the attrib array, must match the shader
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * 4, None)
    glEnableVertexAttribArray(0)

    ## position of the attrib array, must match the shader
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * 4, ctypes.c_void_p(3 * 4))
    glEnableVertexAttribArray(1)

    translations = None
    scales = None
    scale = 0.05
    radius = 0.5

    for x in range(15):
        posx = math.sin(x * math.pi / 15.0 * 2) * radius
        posy = math.cos(x * math.pi / 15.0 * 2) * radius

        if translations is None:
            translations = numpy.array([posx, posy, 0], numpy.float32)
            scales = numpy.array([[scale] * 3], numpy.float32)
        translations = numpy.vstack(
            [translations, numpy.array([posx, posy, 0], numpy.float32)]
        )
        scales = numpy.vstack([scales, numpy.array([scale] * 3, numpy.float32)])
        scale += 0.03

    # Loop until the user closes the window
    while not window_should_close(window):

        # Render here, e.g. using pyOpenGL

        glClearBufferfv(GL_COLOR, 0, (0.0, 0.0, 0.0, 1.0))

        glUseProgram(program)
        glBindVertexArray(vao)

        glDisable(GL_DEPTH_TEST)

        scaleM = glGetUniformLocation(program, "scale")
        transM = glGetUniformLocation(program, "trans")
        # glUniform1i(caseM, 0)

        for scale, translation in zip(scales, translations):
            glUniform3fv(scaleM, 1, scale)
            glUniform3fv(transM, 1, translation)
            glDrawArrays(GL_TRIANGLES, 0, len(vertexData))
            glDrawArrays(GL_LINE_LOOP, 0, len(vertexData))

        # Swap front and back buffers
        swap_buffers(window)

        # Poll for and process events
        poll_events()

    glBindVertexArray(0)
    glDeleteBuffers(1, [vertexBuffer])
    glDeleteProgram(program)
    glDeleteVertexArrays(1, [vao])
    terminate()


if __name__ == "__main__":
    main()