/* get our elements */
const player = document.querySelector('.player');
const video = player.querySelector('.viewer');
const progress = player.querySelector('.progress');
const progressBar = player.querySelector('.progress__filled');
const toggle = player.querySelector('.toggle');
const skipButtons = player.querySelectorAll('[data-skip]');
const ranges = player.querySelectorAll('.player__slider');

/* build our functions */
function togglePlay() {
    const method = video.paused ? 'play' : 'pause';
    video[method](); //access the method name
    /*if (video.paused)  video.play();
    else video.pause();*/

}
function updateButton() { //재생버튼 아이콘
    const icon = this.paused ? '►' : '❚ ❚';
    toggle.textContent = icon;
}
function skip() {
    console.log(this.dataset.skip);
    video.currentTime += parseFloat(this.dataset.skip);
}
function handleRangeUpdate() { //slider
    video[this.name] = this.value;
}
function handleProgress() { //video bar 동기화
    //updating the flexd basis value sort of like updating the width of the progress bar
    const percent = (video.currentTime / video.duration) * 100;
    progressBar.style.flexBasis = `${percent}%`;
}
function scrub(e) { //scrub the video bar
    const scrubTime = (e.offsetX / progress.offsetWidth) * video.duration; //canvas tutorial 참고
    video.currentTime = scrubTime;
}

/* hook up the event listeners */
video.addEventListener('click', togglePlay); //재생버튼 조작
video.addEventListener('play', updateButton); //listen to the video for whenever it is paused
video.addEventListener('pause', updateButton);
video.addEventListener('timeupdate', handleProgress); //triggered when video is updating its timecode

toggle.addEventListener('click', togglePlay); 
skipButtons.forEach(button => button.addEventListener('click', skip));

ranges.forEach(range => range.addEventListener('change', handleRangeUpdate));
ranges.forEach(range => range.addEventListener('mousemove', handleRangeUpdate));

progress.addEventListener('click', scrub);
let mousedown = false; // flag for drag and drop on the video bar
progress.addEventListener('mousemove', (e) => mousedown && scrub(e)); //&&기호를 썼으므로 mousedown이 true여야 scrub(e)가 실행됨
progress.addEventListener('mousedown', () => mousedown = true);
progress.addEventListener('mouseup', () => mousedown = false);

//응용: 혼자 full screen button 만들어보기!