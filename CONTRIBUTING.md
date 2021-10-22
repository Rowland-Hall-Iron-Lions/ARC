<h1 align="center">Bidrar (Contributing)!</h1>
Hello, new (or returning developer)! In our to facilite the smooth developement of our project, we have taken numerous steps to ensure code quality and lower the probability of merge conflicts (when code you wrote clashes with another persons code).

## Personlig åtkomsttoken (Personal Access Token)!
In August of last year, Github deprecated the use of passwords when pushing code to a remote (a repository hosted on the cloud, e.g. someone elses computer). Instead, they want you to use a Personal Access Token (PAT). Think of a PAT like a password, but you can have more than one, and each has different permisions. Don't worry, for now you can have a single PAT that controls everything (you may want to create a unique one for each computer, in case one gets compromised).

Heres how you may create a PAT:
1. Go to [your profile](https://github.com)
2. Go to [your settnigs](https://github.com/settings/profile)
3. Go to [developer settings](https://github.com/settings/apps), then to [Personal Access Tokens](https://github.com/settings/tokens)
4. Click [Generate New Token](https://github.com/settings/tokens/new)
5. Change the note to your computers name (e.g. "School Computer")
6. Set the expiration to never. This is not very secure, but if someone breaks into your account, you can always revoke your token.
10. Check the boxes you want this PAT to control. At the very minimum, include `repo`, and everything under it.
11. Click Generate Token.
12. **Do not exist this page, and make sure to copy your key to your clipborad for now.**

Your token should like roughly like this (I have sense revoked this token, it will not work on my account):
```
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
```

13. After that, open your terminal, and type `git config --global credential.helper`. This will store your PAT (albeit in plain text), so you won't have to type it in again.
14. In order to save your password, try and perform a "restricted action", e.g. cloning a private repository.
15. Enter your username, and paste in your PAT.
16. If all goes well, your PAT is saved! If not, contact me at [milobanks@rowlandhall.org](mailto:milobanks@rowlandhall.org).

## Bidragande kod (Contributing code)!
What good is pushing to the central repository when it reject it? You might get an error like then following when pushing:
```
! [remote rejected] master -> master (protected branch hook declined)
error: failed to push some refs to [and so on]...
```

#### Notera (Note)!
Please make all your changes on a seperate brach, that describes what you are doing, prefixed with your name (e.g. `isacc-barker-fixing-issue-420`, `david-attenborough-gradle-dep-update`). Don't make these too long though.

### Vad är en skyddad gren (What is a protected branch)?
A protected branch is a branch, that is... well... protected. The idea of this is to make sure that the protected branch only has the best code we have to offer. In order to push code into this branch (which people will `clone`), you must fork the repository (you only need to do this once), create a PR (for every *one* major change that you make), get someone to look over your code, and merge it! This may sound complicated, but with a little explanation, it should seem pretty intuitive.

### Vad är en gaffel (What is a fork)?
Imagine have a friend with a repository that contains pictures of [cats](https://en.wikipedia.org/wiki/Cat) (for those of you who do not know what a cat is, a link has been provided for your convience). Now, your friend doesn't have a picture of *your* cat. How dare they‽ You decide you must get your cat photo there, but how? This is everythig comes in handy. If you fork your friends repository, you get a copy. You can do whatever you want with this copy, but most importantly, you can submit your changes (or "open a pull request").

Think of each repository as a dot. Lets graph the relation between your two repositories.

```
[Friends repo] ---------------------------- [Your fork]
```

Simple, right? But what happens if someone else forks your friends repo, but this time to submit a picture of their [dog](https://en.wikipedia.org/wiki/Dog) (again, a link has been provided). The graph would now look like this:

```
                            [-------------- [Dog fork]
[Friends repo] -------------]
                            [-------------- [Your fork]
```

Note that the resemblance to a fork in this diagram is *completely coincidental* (no conspiracy theories please). Remeber these two forks, they will come in handy later.

Ok, so you've have your changes, how do you push your changes back to your friends repo? This is where "pull requests" come in handy.

### Vad är en dragbegäran (What is a pull request)?
Contrary to the name, a pull request (PR) is requesting the original repository (called the upstream) pulls the changes from your fork (called the origin). The reason for this contradictory name is explained [here](https://stackoverflow.com/questions/21657430/why-is-a-git-pull-request-not-called-a-push-request), if anyone is interested. Anyways, once you try and push your changes, you will be met by a window, asking what you want to title your pull request. It will also ask you for a description, in which you should **always** state what you changed. After that, press create pull request!

Depending on how the "upstream" (remember back to the first part of this section) handles pull requets, it may be sent to be reviewed by other people, and it may run through automated testing. In our case (the `ARC` repository), both of these will occur. Don't worry, you won't have to do a thing, save for if something goes wrong. After this process is finished, you may be asked to change your code, or merge. Merging means "merging" or inserting the changes in your pull request into upstream.

This pull request process, and it's associated checking, may seem silly, but remember back to the person who wants to insert their dog. While we do love dogs, there is a strict rule about no dogs where the cats are. A review may be left, saying "move your dog photos to a directory/folder marked dog", and the person would fix that. After this, the pull request will be merged!

### Vad är en sammanslagningskonflikt (What is a merge conflict)?
You have just wandered opon one of the most feared outcomes of Git (or any VCS in general): **a merge conflict**! But don't scream in horror, like I'm sure your peers are doing, and instead follow these instructions. Somewhere on the PR page, it will say you cannot merge due to a merge conflict, and that you must fix them before you can merge. How can you fix them? Well, you have two options.

1. Github might give you the option to solve the conflict online, which you will want to do. Github will walk you though it, but if it doesn't, you will see "conflict markers" (`<<<<<<<` and `>>>>>>>`) in the effected files. Inbetween them, are two versions of code that are conflicting (seperated by `=======`). Figure out which one is better, and make the code valid again.
2. Resolve them locally, on your computer, in case the conflict is too advanced.

In order to solve them on your computer, follow the instructions on Github.

# Frågor (Questions)?
File a Github issue or contact me at my email, [milobanks@rowlandhall.org](mailto:milobanks@rowlandhall.org).

