# Times of India News Viewer

## Overview

The Times of India News Viewer is an Android application that fetches news data from the Times of India website in XML format and presents it to users in a user-friendly list format. Users can view news headlines along with their publication time, date, and an accompanying image. Clicking on a news item opens a WebView to display the full news article from the Times of India website.

## Features

1. **Fetch Times of India News Data:**
   - Utilizes the Times of India API to fetch news data in XML format.
   - Parses the XML data to extract news headlines, publication timeDate, and image URLs.

2. **Display News in a List:**
   - Presents the fetched news data in a scrollable list format using Jetpack Compose.
   - Each news item in the list displays the title, timeDate, and accompanying image.

3. **View Full News Articles:**
   - Allows users to view the full news article by clicking on a news item.
   - Opens a WebView to display the news article from the Times of India website.

## Technologies Used

- **Android Jetpack Compose**: Used for building the user interface in a declarative and modern way.
- **Retrofit**: Used for making HTTP requests to the Times of India API.
- **Jetpack Navigation**: Implemented for navigating between different screens of the application.
- **MVVM Architecture**: Follows the standard MVVM (Model-View-ViewModel) architecture for better separation of concerns and maintainability.
- **XML Parsing**: Utilized to extract news data from the Times of India XML API response.
- **WebView**: Implemented to display full news articles within the application.


## How to Run the Application

1. Clone this repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the application on an Android emulator or device.

## Acknowledgments

- This project makes use of the Times of India API to fetch news data. Special thanks to the Times of India for providing access to their data.

---

Feel free to customize this README.md file to include any additional information specific to your project. Let me know if you need further assistance!
