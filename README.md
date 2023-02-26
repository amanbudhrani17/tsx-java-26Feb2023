# Github Webhook Implementation

This repository is created for the purpose of completing the given assignment. The task is to create a webhook that tracks push, pull, and merge events in a Github account and writes the details of the event to the logger info. It also requires connecting to the Github API to retrieve the list of commits for the "**dummy-github-events**" repository.

## Installation

To run this project, you need to have the following installed on your machine:

- Java 8 or higher
- Gradle

After installing the above dependencies, you can follow the below steps to set up and run the project.

1. Clone the repository to your local machine:
  git clone https://github.com/<your-username>/dummy-github-events.git
  
2. Navigate to the project directory:
  cd dummy-github-events

3. Build the project using Gradle:
  ./gradlew build
  
4. Start the project:
  ./gradlew run
  
  This will start the project and listen for incoming webhooks on http://localhost:8080.
  
5. I've used NGROK to let Github access my Webhook endpoint.
  
  
## Usage

Once the project is set up and running, you can perform pull, push, and merge events for the webhook implementation. All the events will be logged in the console.

To retrieve the list of commits for the "dummy-github-events" repository, you can make a GET request to the following endpoint:
	http://localhost:8080/commits

This will write the list of commits for the repository in the logging information as well as return the list.
