public class OvalController {
    private OvalModel model;
    private OvalView view;

    public OvalController(OvalModel modelIn, OvalView viewIn) {
        model = modelIn;
        view = viewIn;
    }

    public void setVisible() {
        view.setVisible(true);
    }

    public void loadData() {
        model.loadData();
    }

    public void updateView() {
        view.updateView(model.getData());
    }
}