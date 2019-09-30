
import cv2


def opencv_gray_video():
    """ Just open camera and turn grayscale until the user presses "q".

    :return:
    """
    cap = cv2.VideoCapture(0)

    initial = True

    while True:
        # Capture frame-by-frame
        ret, frame = cap.read()

        # Our operations on the frame come here
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

        if initial:
            initial = False
            print(f"Shape of frame: {frame.shape}")
            print(f"Shape of gray: {gray.shape}")

        # Display the resulting frames
        cv2.imshow('Color Frame', frame)
        cv2.imshow('Gray Frame', gray)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()


if __name__ == '__main__':
    opencv_gray_video()
