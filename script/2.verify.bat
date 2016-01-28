@echo off
set workspace=C:\DatosJBB\WorkSpaces\Luna\JEE.Paddle
echo -----------------------------------------
echo . Verify (C)MIW
echo -----------------------------------------
echo .
echo Workspace --- %workspace%
echo .
echo .
cd %workspace%
call mvn clean -Dmaven.test.skip=true verify
pause
