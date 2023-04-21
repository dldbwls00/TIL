import easygui

sen = easygui.enterbox("Write a sentence")
easygui.msgbox("You wrote \""+sen+" \"")
sel = easygui.choicebox("Choose your word to study", choices = sen.split())
easygui.msgbox("Today's word : \n"+sel)
