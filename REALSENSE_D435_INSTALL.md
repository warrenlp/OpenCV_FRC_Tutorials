# Installing Libraries for Intel Realsense D435
This shows how to install the librealsense libraries (including Python) for the FRCVision-pi-gen.

## Install support packages
```
$ sudo apt-get install -y libdrm-amdgpu1 libdrm-dev libdrm-exynos1 libdrm-freedreno1 libdrm-nouveau2 libdrm-omap1 libdrm-radeon1 libdrm-tegra0 libdrm2

$ sudo apt-get install -y libglu1-mesa libglu1-mesa-dev glusterfs-common libglu1-mesa libglu1-mesa-dev libglui-dev libglui2c2

$ sudo apt-get install -y mesa-utils mesa-utils-extra xorg-dev libgtk-3-dev libusb-1.0-0-dev
```
### Add swap for building
```
$ sudo vi /etc/dphys-swapfile
CONF_SWAPSIZE=2048

$ sudo /etc/init.d/dphys-swapfile restart swapon -s
```
### Install git
```
$ sudo apt-get install git -y
```
## Clone librealsense
Using git, clone the librealsense master branch to the rPi.
```
$ git clone https://github.com/IntelRealSense/librealsense.git
```
## Update udev rule
```
$ cd ~
$ cd librealsense
$ sudo cp config/99-realsense-libusb.rules /etc/udev/rules.d/
$ sudo udevadm control --reload-rules && udevadm trigger
```
## Build librealsense libraries including Python wrappers
Within the librealsense folder:
- Create and enter new build directory
```
$ mkdir build
$ cd build
```

### Install RealSense SDK/librealsense
```
$ cmake .. -DCMAKE_BUILD_TYPE=Release -DFORCE_RSUSB_BACKEND=ON
$ make -j1
$ sudo make install
```

### Install pyrealsense2
```
$ cmake .. -DBUILD_PYTHON_BINDINGS=bool:true -DPYTHON_EXECUTABLE=$(which python3)
$ make -j1
$ sudo make install
$ vi ~/.bashrc
export PYTHONPATH=$PYTHONPATH:/usr/local/lib

$ source ~/.bashrc
```

# Change rPi settings (enable OpenGL)
```
$ sudo apt-get install python-opengl
$ sudo -H pip3 install pyopengl
$ sudo -H pip3 install pyopengl_accelerate
$ sudo raspi-config
"7.Advanced Options" - "A8 GL Driver" - "G2 GL (Fake KMS)"
```
