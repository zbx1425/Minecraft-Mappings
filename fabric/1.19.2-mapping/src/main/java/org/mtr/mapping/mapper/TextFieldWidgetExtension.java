package org.mtr.mapping.mapper;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import org.mtr.mapping.annotation.MappedMethod;
import org.mtr.mapping.holder.MutableText;
import org.mtr.mapping.holder.Text;
import org.mtr.mapping.holder.TextFieldWidgetAbstractMapping;
import org.mtr.mapping.holder.TextRenderer;
import org.mtr.mapping.tool.TextCase;

import javax.annotation.Nullable;
import javax.annotation.RegEx;
import java.util.function.Consumer;

public class TextFieldWidgetExtension extends TextFieldWidgetAbstractMapping {

	private final int maxLength;
	private final TextCase textCase;
	private final String filter;
	private final String suggestion;

	@MappedMethod
	public TextFieldWidgetExtension(int x, int y, int width, int height, int maxLength, TextCase textCase, @RegEx @Nullable String filter, @Nullable String suggestion) {
		this(x, y, width, height, "", maxLength, textCase, filter, suggestion);
	}

	@MappedMethod
	public TextFieldWidgetExtension(int x, int y, int width, int height, String message, int maxLength, TextCase textCase, @RegEx @Nullable String filter, @Nullable String suggestion) {
		this(x, y, width, height, TextHelper.literal(message), maxLength, textCase, filter, suggestion);
	}

	@MappedMethod
	public TextFieldWidgetExtension(int x, int y, int width, int height, MutableText text, int maxLength, TextCase textCase, @RegEx @Nullable String filter, @Nullable String suggestion) {
		super(new TextRenderer(MinecraftClient.getInstance().textRenderer), x, y, width, height, new Text(text.data));
		this.maxLength = maxLength;
		this.textCase = textCase;
		this.filter = filter;
		this.suggestion = suggestion;
		setChangedListener2(value -> {
		});
		setMaxLength2(0);
	}

	@MappedMethod
	public void render(GraphicsHolder graphicsHolder, int mouseX, int mouseY, float delta) {
		if (graphicsHolder.matrixStack != null) {
			super.renderButton2(graphicsHolder.matrixStack, mouseX, mouseY, delta);
		}
	}

	@Deprecated
	@Override
	public final void renderButton2(MatrixStack matrices, int mouseX, int mouseY, float delta) {
		GraphicsHolder.createInstanceSafe(matrices, null, graphicsHolder -> render(graphicsHolder, mouseX, mouseY, delta));
	}

	@Deprecated
	@Override
	public final boolean mouseScrolled2(double mouseX, double mouseY, double amount) {
		return mouseScrolled3(mouseX, mouseY, amount);
	}

	@MappedMethod
	public boolean mouseScrolled3(double mouseX, double mouseY, double amount) {
		return super.mouseScrolled2(mouseX, mouseY, amount);
	}

	@MappedMethod
	@Override
	public final void setChangedListener2(Consumer<String> changedListener) {
		super.setChangedListener2(text -> {
			final String newText;
			if (filter == null || filter.isEmpty()) {
				newText = trySetLength(textCase.convert.apply(text));
			} else {
				newText = trySetLength(textCase.convert.apply(text).replaceAll(filter, ""));
				if (!newText.equals(text)) {
					setText2(newText);
				}
			}
			setSuggestion2(newText.isEmpty() && suggestion != null ? suggestion : "");
			changedListener.accept(newText);
		});
	}

	@MappedMethod
	@Override
	public boolean mouseClicked2(double mouseX, double mouseY, int button) {
		if (isVisible2() && isBetween(mouseX, getX2(), getX2() + width) && isBetween(mouseY, getY2(), getY2() + height)) {
			if (button == 1) {
				setText2("");
			}
			return super.mouseClicked2(mouseX, mouseY, 0);
		} else {
			setTextFieldFocused2(false);
			return false;
		}
	}

	@Deprecated
	@Override
	public final void tick2() {
		tick3();
	}

	@MappedMethod
	public void tick3() {
		super.tick2();
	}

	@Deprecated
	@Override
	public final void setMaxLength2(int maxLength) {
		super.setMaxLength2(Integer.MAX_VALUE);
	}

	private String trySetLength(String text) {
		return text.isEmpty() ? "" : text.substring(0, Math.min(maxLength, text.length()));
	}

	private static boolean isBetween(double value, double min, double max) {
		return value >= min && value <= max;
	}

	@MappedMethod
	public final int getX2() {
		return x;
	}

	@MappedMethod
	public final int getY2() {
		return y;
	}

	@MappedMethod
	public final void setX2(int x) {
		this.x = x;
	}

	@MappedMethod
	public final void setY2(int y) {
		this.y = y;
	}

	@MappedMethod
	@Override
	public final boolean isHovered2() {
		return super.isHovered2();
	}
}
