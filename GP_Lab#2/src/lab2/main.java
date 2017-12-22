package lab2;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
////
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class main extends Application {
	
	final Group root = new Group();
	final Xform axisGroup = new Xform();
	final Xform world = new Xform();
	final Xform modelGroup = new Xform();
	final PerspectiveCamera camera = new PerspectiveCamera(true);
    final Xform cameraXform = new Xform();
    final Xform cameraXform2 = new Xform();
    final Xform cameraXform3 = new Xform();
    final Xform modelXform = new Xform();
    private static final double CAMERA_INITIAL_DISTANCE = -650;
    private static final double CAMERA_INITIAL_X_ANGLE = 30.0;
    private static final double CAMERA_INITIAL_Y_ANGLE = 210.0;
    private static final double CAMERA_NEAR_CLIP = 0.1;
    private static final double CAMERA_FAR_CLIP = 10000.0;
    private static final double AXIS_LENGTH = 550.0;
    static double CONTROL_ROTATIONX = 0;
    static double CONTROL_ROTATIONY = 0;
    static double CONTROL_ROTATIONZ = 0;
    //Mouse control
    private static final double CONTROL_MULTIPLIER = 0.1;    private static final double SHIFT_MULTIPLIER = 10.0;    private static final double MOUSE_SPEED = 0.1;    private static final double ROTATION_SPEED = 2.0;    private static final double TRACK_SPEED = 0.3;
    
    double mousePosX;
    double mousePosY;
    double mouseOldX;
    double mouseOldY;
    double mouseDeltaX;
    double mouseDeltaY;
    
    private void buildCamera() {
        root.getChildren().add(cameraXform);
        cameraXform.getChildren().add(cameraXform2);
        cameraXform2.getChildren().add(cameraXform3);
        cameraXform3.getChildren().add(camera);
        cameraXform3.setRotateZ(180.0);
 
        camera.setNearClip(CAMERA_NEAR_CLIP);
        camera.setFarClip(CAMERA_FAR_CLIP);
        camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
        cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
        cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
    }
    private void buildAxes() {
        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setDiffuseColor(Color.DARKRED);
        redMaterial.setSpecularColor(Color.RED);
 
        final PhongMaterial greenMaterial = new PhongMaterial();
        greenMaterial.setDiffuseColor(Color.DARKGREEN);
        greenMaterial.setSpecularColor(Color.GREEN);
 
        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.DARKBLUE);
        blueMaterial.setSpecularColor(Color.BLUE);
 
        final Box xAxis = new Box(AXIS_LENGTH, 1, 1);
        final Box yAxis = new Box(1, AXIS_LENGTH, 1);
        final Box zAxis = new Box(1, 1, AXIS_LENGTH);
        
        xAxis.setMaterial(redMaterial);
        yAxis.setMaterial(greenMaterial);
        zAxis.setMaterial(blueMaterial);
        
        axisGroup.getChildren().addAll(xAxis, yAxis, zAxis);
        axisGroup.setVisible(true);
        world.getChildren().addAll(axisGroup);
    }
    private void buildCube() {
    	 
        final PhongMaterial aquaMaterial = new PhongMaterial();
        aquaMaterial.setDiffuseColor(Color.AQUAMARINE);
        aquaMaterial.setSpecularColor(Color.GOLD);
 
        
        Xform cubeXform = new Xform();

       Box cube = new Box(100,100,100);
       cube.setMaterial(aquaMaterial);
       modelXform.getChildren().add(cube);
       modelXform.setTx(150);
       modelXform.setTy(150);
       modelXform.setTz(150);
       modelXform.setRotateX(CONTROL_ROTATIONX);
       modelXform.setRotateY(CONTROL_ROTATIONY);
       //modelXform.setRotateZ(CONTROL_ROTATIONZ);
       
       modelGroup.getChildren().add(modelXform);

       world.getChildren().addAll(modelGroup);
 }
    private void handleMouse(Scene scene, final Node root) {
    	 
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent me) {
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseOldX = me.getSceneX();
                mouseOldY = me.getSceneY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent me) {
                mouseOldX = mousePosX;
                mouseOldY = mousePosY;
                mousePosX = me.getSceneX();
                mousePosY = me.getSceneY();
                mouseDeltaX = (mousePosX - mouseOldX); 
                mouseDeltaY = (mousePosY - mouseOldY);

               double modifier = 1.0;

               if (me.isControlDown()) {
                    modifier = CONTROL_MULTIPLIER;
                } 
                if (me.isShiftDown()) {
                    modifier = SHIFT_MULTIPLIER;
                }     
                if (me.isPrimaryButtonDown()) {
                	
                	CONTROL_ROTATIONX = CONTROL_ROTATIONX + mouseDeltaY*MOUSE_SPEED*modifier*ROTATION_SPEED;
                	CONTROL_ROTATIONY = CONTROL_ROTATIONY + mouseDeltaX*MOUSE_SPEED*modifier*ROTATION_SPEED;
                	modelXform.setRotateX(CONTROL_ROTATIONX);
                	modelXform.setRotateY(CONTROL_ROTATIONY);
                    
                }
                else if (me.isSecondaryButtonDown()) {
                    double z = camera.getTranslateZ();
                    double newZ = z + mouseDeltaX*MOUSE_SPEED*modifier;
                    camera.setTranslateZ(newZ);
                    
                }
                else if (me.isMiddleButtonDown()) {
                   cameraXform2.t.setX(cameraXform2.t.getX() + 
                      mouseDeltaX*MOUSE_SPEED*modifier*TRACK_SPEED);  // -
                   cameraXform2.t.setY(cameraXform2.t.getY() + 
                      mouseDeltaY*MOUSE_SPEED*modifier*TRACK_SPEED);  // -
                }
           }
       }); // setOnMouseDragged
   } //handleMouse
    private void handleKeyboard(Scene scene, final Node root) {

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
               switch (event.getCode()) {
                   case Z:
                       cameraXform2.t.setX(0.0);
                       cameraXform2.t.setY(0.0);
                       cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
                       cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
                       break;
                   case X:
                        axisGroup.setVisible(!axisGroup.isVisible());
                        break;
                    case V:
                       modelGroup.setVisible(!modelGroup.isVisible());
                       break;
               } // switch
            } // handle()
        });  // setOnKeyPressed
    }  //  handleKeyboard()
    
	@Override
	public void start(Stage primaryStage) {
		root.getChildren().add(world);
        root.setDepthTest(DepthTest.ENABLE);
		buildCamera();
		buildAxes();
		buildCube();
	
		try {

			Scene scene = new Scene(root,1024,768,true);
			scene.setFill(Color.GREY);
			handleKeyboard(scene, world);
	        handleMouse(scene, world);
	        
			//scene.getStylesheets().add(getClass().getResource("/GC_lab2/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			scene.setCamera(camera);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}