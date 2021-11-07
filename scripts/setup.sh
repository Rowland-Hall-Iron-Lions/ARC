SETUP_LOCKFILE_NAME="./.setup.lock"
SHELL_NAME=`basename $SHELL`
JAVA_VERSION=`java -version 2>&1 | grep -i version | cut -d'"' -f2 | cut -d'.' -f1-2`
TARGET_JAVA_VERSION=11.0
SDKMAN_JAVA_INSTALL=11.0.11.hs-adpt
FORCE_SDKMAN=true
FORCE_JAVA=true
FORCE_PREREQUISITES=true

command_not_found() {
    echo "'$1' could not be found, or is not an executable file in your PATH."
    echo "If on a mac, consider doing xcode-select --install."
    echo "If on linux, you already know how this works."
    echo "If on windows, get a life."
}

usage() {
    echo "usage: setup"
    echo "\tno arguments"
}

progress() {
    # Magic!
    printf "\t\\033[1;32m$1\\033[0m\t\\033[1;m$2\\033[0m\\n"
}

error() {
    # Magic!
    printf "\t\\033[0;31m$1\\033[0m\t\\033[1;m$2\\033[0m\\n"
}

setup() {
    echo $FORCE_PREREQUISITES
    progress pre "Downloading prerequisites...."
    prerequisites

    progress jdk "Getting JDK $TARGET_JAVA_VERSION...."
    setup_jdk

    progress finish "Done with setup! Please follow the simple build instructions in the README on how to build the binary from the command line. Other wise, just click the \"Build\" button inside Android Studio."
}

prerequisites() {
    if [[ "$FORCE_PREREQUISITES" == "true" ]]
    then
        ./scripts/prerequisites.sh -d
    else
        progress pre "Not forcing prerequisites on request, skipping step...."
    fi
}

setup_jdk() {
    if [ "$JAVA_VERSION" != "$TARGET_JAVA_VERSION" ] || [ $FORCE_JAVA == "true" ]
    then
        progress jdk "Found JDK $JAVA_VERSION, which is NOT JDK $TARGET_JAVA_VERSION. Installing JDK $TARGET_JAVA_VERSION...."

        if [[ "`command -v sdk`" != *"sdk"* || $FORCE_SDK == "true" ]]
        then
            progress sdk "Installing sdkman to manage JDK versions...."
            curl -s "https://get.sdkman.io" | bash
        else
            progress sdk "sdkman already installed, skipping install step (but still installing JDK $TARGET_JAVA_VERSION, if applicable)...."
        fi

        source $HOME/.sdkman/bin/sdkman-init.sh

        progress jdk "Installing JDK $TARGET_JAVA_VERSION with sdkman...."
        sdk install java $SDKMAN_JAVA_INSTALL
    else
        progress jdk "JDK $TARGET_JAVA_VERSION already downloaded, skiping step...."
        return
    fi
}

if [[ -f "$SETUP_LOCKFILE_NAME" ]]
then
    error lock "Lockfile ($SETUP_LOCKFILE_NAME) already exists, which means that that your repostiory has already been setup."
    error info "If you would still like to continue, please clean the prerequisites:"
    error info "\t./scripts/prerequisites.sh -c"
    error info "And remove the lockfile at $SETUP_LOCKFILE_NAME. After that, run this script again."
    echo
    error info "You may also choose to do a hard reset (you will lose all your changes that you have not commited):"
    error info "\tgit reset --hard"

    exit
fi

progress setup "Setting up...."
setup

touch $SETUP_LOCKFILE_NAME

