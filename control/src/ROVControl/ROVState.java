package ROVControl;

import java.util.*;

/**
 * A mutable representation of the state of an ROV.
 */
public class ROVState {
    private float verticalSpeed;
    private float forwardSpeed;
    private float rightSpeed;
    private float rotationSpeed;
    private ArrayList<Boolean> lights;

    /**
     * Constructs a new, default ROVState.
     * @modifies this
     * @effects this is a new ROVState with no lights and a speed of 0.
     */
    public ROVState() {
        verticalSpeed = 0;
        forwardSpeed = 0;
        rightSpeed = 0;
        rotationSpeed = 0;
        lights = new ArrayList<>();
    }

    /**
     * Makes an independent copy of this ROVState.
     * @return a copy of this ROVState.
     */
    public ROVState copy() {
        ROVState state = new ROVState();
        // Notice that we can get private fields inside the ROVState that we made.
        state.verticalSpeed = verticalSpeed;
        state.forwardSpeed = forwardSpeed;
        state.rightSpeed = rightSpeed;
        state.rotationSpeed = rotationSpeed;
        state.lights = new ArrayList<>(lights);
        return state;
    }

    /**
     * Sets the horizontal (forward and right) speed components of the ROV State.
     * @param forwardSpeed forward speed component
     * @param rightSpeed right speed component
     * @requires forwardSpeed and rightSpeed must be between [-1, 1] (inclusive).
     * @modifies this
     * @effects set forward speed and right speed of the ROVState to the given values.
     */
    public void setHorizontalSpeed(float forwardSpeed, float rightSpeed) {
        if (forwardSpeed < -1 || forwardSpeed > 1) {
            throw new IllegalArgumentException("Forward speed must be between [-1, 1].");
        }
        if (rightSpeed < -1 || rightSpeed > 1) {
            throw new IllegalArgumentException("Right speed must be between [-1, 1].");
        }

        setForwardSpeed(forwardSpeed);
        setRightSpeed(rightSpeed);
    }

    /**
     * Sets the forward speed component of the ROV State
     * @param forwardSpeed forward speed component
     * @requires forwardSpeed must be between [-1, 1] (inclusive)
     * @modifies this
     * @effects set forward speed of the ROVState to the given value
     */
    public void setForwardSpeed(float forwardSpeed) {
        if (forwardSpeed < -1 || forwardSpeed > 1) {
            throw new IllegalArgumentException("Forward speed must be between [-1, 1]");
        }
        this.forwardSpeed = forwardSpeed;
    }

    /**
     * Sets the right speed component of the ROV State
     * @param rightSpeed forward speed component
     * @requires rightSpeed must be between [-1, 1] (inclusive)
     * @modifies this
     * @effects set right speed of the ROVState to the given value
     */
    public void setRightSpeed(float rightSpeed) {
        if (rightSpeed < -1 || rightSpeed > 1) {
            throw new IllegalArgumentException("Forward speed must be between [-1, 1]");
        }
        this.rightSpeed = rightSpeed;
    }

    /**
     * Gets the forward speed of the ROV State.
     * @return forward speed.
     */
    public float getForwardSpeed() {
       return forwardSpeed;
    }
    
    /**
     * Gets the right speed of the ROV State.
     * @return right speed.
     */
    public float getRightSpeed() {
       return rightSpeed;
    }

    /**
     * Sets the vertical speed components of the ROV State.
     * @param verticalSpeed vertical speed component
     * @requires verticalSpeed must be between [-1, 1] (inclusive).
     * @modifies this
     * @effects set vertical speed of the ROVState to the given value.
     */
    public void setVerticalSpeed(float verticalSpeed) {
       if (verticalSpeed < -1 || verticalSpeed > 1) {
          throw new IllegalArgumentException("Vertical speed must be between [-1, 1].");
       }
       this.verticalSpeed = verticalSpeed;
    }
    
    /**
     * Gets the vertical speed of the ROV State.
     * @return vertical speed.
     */
    public float getVerticalSpeed() {
       return verticalSpeed;
    }
    
    /**
     * Sets the rotational speed components of the ROV State.
     * @param rotationSpeed rotational speed component
     * @requires rotateSpeed must be between [-1, 1] (inclusive).
     * @modifies this
     * @effects set rotational speed of the ROVState to the given value.
     */
    public void setRotationSpeed(float rotationSpeed) {
       if (rotationSpeed < -1 || rotationSpeed > 1) {
          throw new IllegalArgumentException("Rotational speed must be between [-1, 1].");
       }
       this.rotationSpeed = rotationSpeed;
    }
    
    /**
     * Gets the rotational speed of the ROV State.
     * @return rotation speed.
     */
    public float getRotationSpeed() {
        return rotationSpeed;
    }
    
    /**
     * Turns on all the lights of the ROV
     * @modifies this
     * @effects turn on all lights
     */
    public void turnOnLights() {
        for (int i = 0; i < lights.size(); i++) {
            lights.set(i, true);
        }
    }
    
    /**
     * Turns off all the lights of the ROV
     * @modifies this
     * @effects turn off all lights
     */
    public void turnOffLights() {
        for (int i = 0; i < lights.size(); i++) {
            lights.set(i, false);
        }
    }

    /**
     * Sets the number of lights of the ROV
     * @param index the number of lights of the ROV
     * @requires {@code index} >= 0
     * @modifies this
     * @effects adds lights up to the index
     */
    public void setLightsSize(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Invalid index.");
        }
        while (index > lights.size()) {
            lights.add(false);
        }
    }

    /**
     * Sets the state of a light in the given index.
     * @param index index of the light state to be switched
     * @requires 0 <= {@code index} < {@code getLightsSize()}
     * @modifies this
     * @effects changes the status of the light at {@code index} to {@code state}
     */
    public void setLightState(int index, boolean state) {
        if (index < 0 || index >= getLightsSize()) {
            throw new IllegalArgumentException("Invalid index.");
        }
        lights.set(index, state);
    }

    /**
     * Gets the state of the lights at the given index
     * @param index index of the light to return the state of
     * @return returns the state of the light at the given index
     */
    public boolean getLightState(int index) {
        if (index < 0 || index > lights.size()) {
            throw new IllegalArgumentException("Invalid index.");
        }
        return lights.get(index);
    }

    /**
     * Gets the number of lights of the ROV
     * @return number of lights of the ROV
     */
    public int getLightsSize() {
        return lights.size();
    }

}
