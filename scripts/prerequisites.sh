#!/usr/bin/env bash

command_not_found() {
    echo "'$1' could not be found, or is not an executable file in your PATH."
    echo "If on a mac, consider doing xcode-select --install."
    echo "If on linux, you already know how this works."
    echo "If on windows, get a life."
}

usage() {
    echo "usage: prerequisites [-dch]"
    echo -e "\t-d\tDownload"
    echo -e "\t-c\tClean"
    echo -e "\t-h\tHelp"
}

progress() {
    # Magic!
    printf "\t\\033[1;32m$1\\033[0m\t\\033[1;m$2\\033[0m\\n"
}

if ! command -v git &> /dev/null
then
    command_not_found git
    exit
fi

if ! command -v getopts &> /dev/null
then
    command_not_found getopts
    exit
fi

INITIAL_DIR=$(pwd)
TEAMCODE_DIR="$INITIAL_DIR/TeamCode/src/main/java/org/rowlandhall/arc"
ROADRUNNER_CONTAINED_DIR=$TEAMCODE_DIR/lib/roadrunner/

roadrunner() {
    progress git "Gitting...."
    rm -rf /tmp/dep/roadrunner
    git clone https://github.com/acmerobotics/road-runner-quickstart.git /tmp/dep/roadrunner # || process git "Failed to fetch road runner, aborting...."; exit
    cd /tmp/dep/roadrunner

    # Checkout the right version. This may be updated, which is the whole purpose of this script.
    progress git "Checking out known version...."
    git checkout -q 1a52698a48594d65ffca71066928b0466eddbdd0

    # Change into the source directory
    progress setup "Setting up environment...."
    cd TeamCode/src/main/java/org/firstinspires/ftc/teamcode/

    # Delete unnessisary example opmodes (saves on compile time)
    progress setup "Deleted unnessisary code (reduce compile times)...."
    rm -rf drive/opmode

    # Move all the files we need into the correct directory
    progress mv "Moving files...."
    mkdir -p "$ROADRUNNER_CONTAINED_DIR"

    mv -f drive "$ROADRUNNER_CONTAINED_DIR"
    mv trajectorysequence "$ROADRUNNER_CONTAINED_DIR"
    mv util "$ROADRUNNER_CONTAINED_DIR"

    # Go back to where we were
    cd "$INITIAL_DIR"
}

roadrunner_clean() {
    progress rm "Removing files...."
    rm -rf "$ROADRUNNER_CONTAINED_DIR/drive"
    rm -rf "$ROADRUNNER_CONTAINED_DIR/trajectorysequence"
    rm -rf "$ROADRUNNER_CONTAINED_DIR/util"
}

download_prerequisites() {
    # Init code
    mkdir -p tmp/dep
    mkdir -p "$ROADRUNNER_CONTAINED_DIR"

    roadrunner
}

clean_prerequisites() {
    roadrunner_clean
}

while getopts dch flag
do
    case "${flag}" in
        d) 
            progress download "Installing/downloading prerequisites...."
            download_prerequisites
            exit
            ;;

        c)
            progress clean "Cleaning prerequisites...."
            clean_prerequisites
            exit
            ;;
        h)
            usage
            exit
            ;; 

        *)
            usage
            exit
            ;;
    esac
done

usage

