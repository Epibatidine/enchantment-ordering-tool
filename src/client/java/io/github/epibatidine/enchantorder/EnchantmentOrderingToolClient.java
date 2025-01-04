package io.github.epibatidine.enchantorder;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.input.InputUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public class EnchantmentOrderingTool implements ClientModInitializer {
	// Define the keybinding for opening the menu (e.g., E key)
	public static final KeyBinding OPEN_ENCHANTMENT_MENU_KEY =
			new KeyBinding("key.enchantmentorder.open", GLFW.GLFW_KEY_E, "category.enchantmentorder");

	@Override
	public void onInitializeClient() {
		// Register the keybinding
		KeyBindingHelper.registerKeyBinding(OPEN_ENCHANTMENT_MENU_KEY);

		// Listen for key press and open the screen when the key is pressed
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (OPEN_ENCHANTMENT_MENU_KEY.wasPressed()) {
				MinecraftClient.getInstance().openScreen(new EnchantmentMenuScreen());
			}
		});
	}
}
