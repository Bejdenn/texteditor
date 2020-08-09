package com.elinis.texteditor.frontend.view.component.menubar;

import de.saxsys.mvvmfx.utils.commands.Command;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination.Modifier;

/**
 * Multi-step builder to construct a {@link MenuBar}.
 */
public class MenuBarBuilder {

    private MenuBar menuBar = new MenuBar();

    private MenuBarBuilder() {
        // only static access to builder
    }

    public static MenuBarBuilder newMenuBar() {
        return new MenuBarBuilder();
    }

    public MenuBuilder newMenu(String identifier) {
        return new MenuBuilder(identifier);
    }

    public MenuBar buildMenuBar() {
        return menuBar;
    }

    /**
     * Sub-builder to construct a single {@link Menu} for a {@link MenuBar}.
     */
    public class MenuBuilder {

        private Menu menu;

        private MenuBuilder(String description) {
            menu = new Menu(description);
        }

        public MenuItemBuilder newMenuItem(String identifier) {
            return new MenuItemBuilder(identifier);
        }

        public MenuBarBuilder buildMenu() {
            MenuBarBuilder.this.menuBar.getMenus().add(menu);
            return MenuBarBuilder.this;
        }

        /**
         * Sub-builder to construct a single {@link MenuItem} for a {@link Menu}.
         */
        public class MenuItemBuilder {

            private MenuItem menuItem;

            private MenuItemBuilder(String identifier) {
                menuItem = new MenuItem(identifier);
            }

            public MenuItemBuilder withKeyCombination(Modifier keyCombination, KeyCode keyCode) {
                menuItem.setAccelerator(new KeyCodeCombination(keyCode, keyCombination));
                return this;
            }

            public MenuItemBuilder withCommand(Command command) {
                menuItem.setOnAction(e -> command.execute());
                return this;
            }

            public MenuBuilder buildMenuItem() {
                MenuBuilder.this.menu.getItems().add(menuItem);
                return MenuBuilder.this;
            }
        }
    }
}
