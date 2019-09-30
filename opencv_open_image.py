
import cv2


def opencv_image():
    """ Nothing special. Just open an image and display it until the user presses "q".

    :return:
    """
    img = cv2.imread("opencv_screenshot.jpg", cv2.IMREAD_GRAYSCALE)
    cv2.imshow('Image Title', img)

    while True:
        print("Starting to wait for key")
        key_press = cv2.waitKey(0) & 0xFF
        print(f"Finished waiting for key: {chr(key_press)}")
        if key_press == ord('q'):
            print("Destroying all windows")
            cv2.destroyAllWindows()
            break
        else:
            print(f"Sorry, key: '{chr(key_press)}' is not 'q'")


if __name__ == '__main__':
    opencv_image()
