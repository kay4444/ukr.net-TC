#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here

; Wait 10 seconds for the Upload window to appear

  Local $hWnd = WinWait("Відвантаження файлу","",10)

; Set input focus to the edit control of Upload window using the handle returned by WinWait

  ControlFocus($hWnd,"","Edit1")

; Wait for 2 seconds.

  Sleep(2000)

;ShellExecute(@MyDocumentsDir)
;$Path = "D:\Pictures"
;ShellExecute($path)

; Enter URL and click Enter button
;ControlFocus($hWnd,"","ToolbarWindow323")
;MouseClick("left",0,521,11)
;Sleep(1000)
;MouseClick("right")
;Sleep(1000)
;ControlFocus($hWnd,"","ToolbarWindow322")
;MouseClick("right",109,42,1)
;ControlFocus($hWnd,"","ToolbarWindow322")
;MouseClick("left")
;Send ("D:\Pictures{ENTER}")
;Send("{DELETE}")
;ControlSetText($hWnd, "", "ToolbarWindow322", "D:\Pictures")
;Sleep(1000)
;Send("{ENTER}")
;Sleep(2000)

; Set the File name text on the Edit field

ControlSetText($hWnd, "", "Edit1", "D:\Pictures\Assassins-Creed-Revelations-Cover-Poster.jpg")

  Sleep(2000)

; Click on the Open button

  ControlClick($hWnd, "","Button1");