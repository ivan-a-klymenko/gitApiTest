# XING Android Coding Challenge

Welcome to the XING Coding Challenge! This challenge will give us an idea about your coding skills. You get access to this repository for 48 hours. We expect this challenge to take you between 4 and 6 hours so please plan accordingly.

## Prerequisites

* Please use Kotlin for this challenge.
* Do not focus too much on the design of the UI.
* The usage of third party libraries is explicitly allowed.
* Provide a comprehensive git history.
* If you want to use different branches, please make sure that they’ll be merged into the master branch when you’ll finish the task.
* If your API request limit exceeds, you can generate and use a personal access token [here](https://github.com/settings/applications) and add `?access_token=<YOUR_ACCESS_TOKEN>` to the request URLs.

## Goals

1. Clone this repository. Use it as your working directory.
2. Bootstrap a new empty application.
3. Request the GitHub API to show [XING's public repositories](https://api.github.com/orgs/xing/repos) and parse the JSON response. You can find documentation to the call [here](https://docs.github.com/en/free-pro-team@latest/rest/reference/repos#list-organization-repositories).
4. Display a list of repositories, with each entry showing:
	* name of the repository
	* description
	* login of the owner
5. Show a light green background if the repository is forked or a white one otherwise.
6. The business logic should be tested by unit tests.

## Bonus Goals

* Cache the data so it is available offline.
* Implement a load more mechanism. The load more should be triggered when the scrolling is close to reaching the end of the list. Check out the [pagination documentation](https://docs.github.com/en/free-pro-team@latest/rest/guides/traversing-with-pagination) for more info.
* When long-pressing an item of the list, show a dialog asking the user whether they want to visit the repository's `html_url` or the owner's `html_url` and open the selected one in a browser.
* Display the owner’s avatar image and cache it accordingly.

## General Advice and Tips
* Please keep the code as simple as possible and remove any unused code.
* Make sure the project is well-structured.
* Keep in mind the [Separation of concerns](https://en.wikipedia.org/wiki/Separation_of_concerns), and the [SOLID principles](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)).
* You can use a reactive approach (Ex. RxJava).
* Don't forget the tests, they are really important to us.
* Be conscious and consistent regarding your coding style.
* Have fun reading and writing code.
* Please provide any notes and comments about your solution in the [final_notes.md](final_notes.md)

Now, let's get started. We wish you good luck!
