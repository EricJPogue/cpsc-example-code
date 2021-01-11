public class OvalDrawMVC {
    public static void main(String[] args) {
        // Setup the model.
        OvalModel model = new OvalModel();
        OvalView view = new OvalView(); 
        OvalController controller = new OvalController(model,view); 

        // Update everything through the controller.
        controller.setVisible();
        controller.loadData();
        controller.updateView();
    }
}