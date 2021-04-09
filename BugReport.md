# Wide FillViewport not centred to screen on high resolution iOS devices in portrait mode

#### Issue details

I've spotted a bug with FillViewport on iOS devices with very high
resolutions. The bug occurs when displaying a very wide FillVieport on
an iOS screen in portait mode. On higher resolution devices the
FillViewport appears to be "shifted" to the left, instead of centred
on the screen as expected.

NB I am using Xcode Simulator for all of this testing. The physical
devices I have available, iPhone 7 and iPad 9.7-inch do not show this bug.

I was using a FillViewport with landscape world dimensions (e.g. 1280
x 720) on a game displayed in portrait mode on iOS devices. My
intention was to show more of two banners to either side of the
central game area on devices that are wider than a 9:16 aspect ratio
in portrait mode (e.g. 3:4 iPads, or a 16:9 window on desktop). On
desktop, Android devices in portait mode, and lower resolution iOS
devices (e.g. iPhone 11, iPad (8th generation)) in portrait mode, the
FillViewport is centred on the screen as expected. On higher
resolution iOS devices like iPhone 12 Pro Max and iPad Pro (12.9-inch)
(4th generation) the FillViewport appears to "shift" to the left.

#### Reproduction steps/code

The sample project at https://github.com/anhinton/FillViewportBug
creates a 1280 x 720 FillViewport, and draws a texture to it which
fills the entire Viewport. On iPhone 11 and iPad (8th generation) in
portrait the texture in the Viewport is centred on the screen as
expected. On iPhone 12 Pro Max and iPad Pro (12.9-inch)
(4th generation) the FillViewport appears to "shift" to the left. The
README for this project shows screenshots of the bug.

#### Version of LibGDX and/or relevant dependencies
1.9.13 and 1.9.15-SNAPSHOT

#### Please select the affected platforms
- [ ] Android
- [x] iOS
- [ ] HTML/GWT
- [ ] Windows
- [ ] Linux
- [ ] MacOS
