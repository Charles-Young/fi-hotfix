# Project Fi Unofficial Hotfix

### The Issue
Users (including myself) have reported that cellular data communications cannot be disabled on Project Fi when connected to T-Mobile's network.  When I spoke with the Project Fi Engineers they said that, "most users reporting this issue have at some point shut their device down while the 'Cellular Data' toggle was in the 'OFF' position. Upon powering their phone on, the toggle malfunctions, resulting in cellular data connections being preferred over Wi-Fi connections."  They told me that the temporary resolution to the problem is to "restart the device while the toggle is in the 'ON' position."  After proving that restarting the device with cellular data enabled fixed the issue temporarily I started working on this application to automate this action on every shutdown and boot up.

### How I created the hotfix
This application uses BroadcastReceivers to handle ```ACTION_SHUTDOWN``` and ```BOOT_COMPLETED``` intents.  During shutdown the application checks what the current cellular data toggle position is and saves it to storage using ```SharedPreferences```.  Then, cellular data is enabled by executing ```svc data enable``` before the device turns off.  On the next boot, the ```RestoreDataState``` class is run which reads the pre-shutdown cellular data state from ```SharedPreferences``` and runs ```svc data + pre-Shutdown state```.

### Libraries used
"[libsuperuser](https://github.com/Chainfire/libsuperuser)" by Chainfire

"[Material design icons](https://github.com/google/material-design-icons)" by Google
