# FillViewport iOS bug

I have noticed a problem with FillViewport in some devices using the Xcode Simulator, but not
others.

For context, the app is displayed in portrait mode. When the device aspect ratio is wider
than my game dimensions (720 x 1280) I want to display banners to the left and right of the game 
area. These banners should go all the way to the edge of a 16:9 device (my Destkop aspect ratio).
On tablets you should see just the edges of the banners.

The potential bug I have seen appears to "shift" the FillViewport to the left.

FillViewport works as expected on the physical devices I have for testing (iPhone 7 and 
iPad 9.7-inch 6th generation).

Using Xcode Simulator the following screenshots show the expected results on iPhone 11 and
iPad (8th generation):

![Simulator Screen Shot - iPhone 11](Simulator Screen Shot - iPhone 11 - 2021-04-08 at 09.33.07.png)

![Simulator Screen Shot - iPad (8th generation)](Simulator Screen Shot - iPad (8th generation) - 2021-04-08 at 09.31.24.png)

The following screenshots show the possible display bug seen in Simulator on iPhone 12 Pro Max
and iPad Pro (12.9-inch) (4th generation). I have also observed this error in Simulator on
iPhone 11 Pro Max.

![Simulator Screen Shot - iPhone 12 Pro Max](Simulator Screen Shot - iPhone 12 Pro Max - 2021-04-08 at 09.34.55.png)

![Simulator Screen Shot - iPad Pro (12.9-inch) (4th generation)](Simulator Screen Shot - iPad Pro (12.9-inch) (4th generation) - 2021-04-08 at 09.37.25.png)