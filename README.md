<img width="1280" alt="Screen Shot 2019-03-20 at 11 59 59 AM" src="https://user-images.githubusercontent.com/7444521/54711800-0196ea80-4b08-11e9-92ce-0ec8079e34b9.png">


# Soda Labs Popcast Player


### Design and Motivation

What a crazy three hours.  I managed to include the functionality for selecting, playing, and pausing a podcast as well as the ability to play the next or previoius item in the list.  Android's MediaPlayer class was used to take advantage of its encapsulation.  The app was all done in the view layer, regrettably.

My focus was to ensure that the user could enter the app and have the basic functionality.  The user's experience is such an important part of an application so it was difficult to pull myself away from that task to ensure the requirements of the assignment were met.

A RecyclerView nested within a fragment was used to display the items while the MediaPlayer and its controls were kept at the level of our activity.  This allows for the persistance of the audio while the user navigates to other views.

### If Only We Had More Time

* Use Android's SeekBar component to enable audio tracking and the associated visuals
* Each ViewHolder in the list would contain more data that is necessary for the user such as duration, and image, and the option to click into the podcast for more detail on another Fragment.
* A series of broadcast receivers to control the audio from notifications or home screen to be received by a background service
* Follow clean architecture to seperation of responsibilities into view, presenter, and domain later.  Click listeners should be making a call to our ViewModel which processes the business logic and delegates the work to help classes and to the domain aka web layer.
* The MediaPlayer should be its own class processing events.
* Integration of the podcast API using Retrofit2 and RxJava (or Kotlin Coroutines) from the domain layer 
