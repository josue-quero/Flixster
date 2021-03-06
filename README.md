# Project 2 - *Flixster*

**Flixster** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **15** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through current movies** from the Movie Database API
* [x] Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
* [x] For each movie displayed, user can see the following details:
  * [x] Title, Poster Image, Overview (Portrait mode)
  * [x] Title, Backdrop Image, Overview (Landscape mode)
* [x] Allow user to view details of the movie including ratings within a separate activity

The following **stretch** features are implemented:

* [x] Improved the user interface by experimenting with styling and coloring.
* [x] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#transformations)
* [x] Apply the popular [View Binding annotation library](http://guides.codepath.org/android/Reducing-View-Boilerplate-with-ViewBinding) to reduce boilerplate code.
* [x] Allow video trailers to be played in full-screen using the YouTubePlayerView from the details screen.

The following **additional** features are implemented:

* [x] In the details of the movie, I also included a Poster Image.
* [x] In the details of the movie, I also included the date of release.
* [x] I added a button image so that it is easier for the users to realize they are able to click on the image and watch the trailer for the movie.
* [x] I made the layouts of the detail page in such a way that in both landscape and vertical mode the items are viewed correctly.

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='screenshots/verticalwalkthrough.gif' title='Vertical Video Walkthrough' width='' alt='Vertical Video Walkthrough' />

<img src='screenshots/horizontalwalkthrough.gif' title='Vertical Video Walkthrough' width='' alt='Vertical Video Walkthrough' />

GIF created with [Kap](https://getkap.co/).

## Notes

The main challenge with this one was the need to have a deeper understanding of the Recycler View and Layouts in order to develop a more pleasant user experience, mostly in the visual aspect. For example, I used a LinearLayout inside a RelativeLayout to display each movie in a homogeneous way. Furthermore, the API implementation for the YouTube videos represented a great opportunity to learn how to handle videos and thus, get a deeper understanding on how to make GET requests.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android
- [YouTube Android Player API](https://developers.google.com/youtube/android/player/) - YouTube Android Player API

## License

    Copyright [2021] [David Marcial]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
