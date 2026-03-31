@echo off
setlocal

:: %~dp0 always resolves to this script's own directory (even on UNC paths),
:: regardless of the broken working directory CMD falls back to.
set "PROJECT_DIR=%~dp0"

:: pushd on a UNC path auto-assigns a temporary drive letter (e.g. Z:)
:: and changes into it — giving Maven a valid non-UNC working directory.
pushd "%PROJECT_DIR%"

:: Ensure Java 21 is used (required for Spring Boot 3.x)
set "JAVA_HOME=C:\Program Files\Java\jdk-21"
set "PATH=%JAVA_HOME%\bin;%PATH%"

:: Delegate to the real Maven, forwarding all original arguments from IntelliJ
call "C:\Users\rajuro\JetBrainsPlugins\maven\lib\maven3\bin\mvn.cmd" %*

set EXIT_CODE=%ERRORLEVEL%
popd
endlocal
exit /b %EXIT_CODE%

