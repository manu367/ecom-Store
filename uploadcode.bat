@echo off
REM ==============================
REM  Push local project to GitHub
REM  Author: Manu Pathak
REM ==============================

REM ---- Project directory ----

REM ---- Initialize Git ----
git init

REM ---- Add all files ----
git add .

REM ---- Commit changes ----
git commit -m "Project Updates"

REM ---- Set branch name ----
git branch -M main

REM ---- Add remote repo ----
git remote add origin https://github.com/manu367/ecom-Store.git

REM ---- Push to GitHub ----
git push -u origin main

REM ---- Confirmation ----
echo.
echo ✅ Project pushed to GitHub successfully!
pause
