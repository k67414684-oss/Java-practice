package practice10;

abstract class UiWidget {
    protected String id;
    protected int width, height;
    public UiWidget(String id, int width, int height) { this.id = id; this.width = width; this.height = height; }
    public abstract String renderHtml();
}
class ButtonWidget extends UiWidget {
    private final String label;
    public ButtonWidget(String id, int w, int h, String label) { super(id, w, h); this.label = label; }
    @Override public String renderHtml() { return "<button id='" + id + "' style='width:" + width + "px;height:" + height + "px'>" + label + "</button>"; }
}
class TextInputWidget extends UiWidget {
    private final String placeholder;
    public TextInputWidget(String id, int w, int h, String placeholder) { super(id, w, h); this.placeholder = placeholder; }
    @Override public String renderHtml() { return "<input id='" + id + "' placeholder='" + placeholder + "'/>"; }
}
class ProgressBarWidget extends UiWidget {
    private final int progressPercent;
    public ProgressBarWidget(String id, int w, int h, int p) { super(id, w, h); this.progressPercent = Math.max(0, Math.min(100, p)); }
    @Override public String renderHtml() { return "<progress id='" + id + "' value='" + progressPercent + "' max='100'></progress>"; }
}

public class Ex7 {
    public static String buildPage(UiWidget[] elements) {
        StringBuilder html = new StringBuilder("<html><body>\n");
        for (UiWidget w : elements) html.append("  ").append(w.renderHtml()).append("\n");
        html.append("</body></html>");
        return html.toString();
    }

    public static void main(String[] args) {
        UiWidget[] page = {
                new TextInputWidget("email", 220, 32, "Введіть email"),
                new ProgressBarWidget("upload", 220, 16, 80),
                new ButtonWidget("submit", 120, 36, "Надіслати")
        };
        System.out.println(buildPage(page));
    }
}
