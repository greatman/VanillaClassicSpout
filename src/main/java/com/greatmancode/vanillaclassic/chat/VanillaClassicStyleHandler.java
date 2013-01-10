/*
 * This file is part of VanillaClassic.
 *
 * Copyright (c) 2012 - 2013, Greatman <http://www.github.com/greatman/>
 * VanillaClassic is licensed under the SpoutDev License Version 1.
 *
 * VanillaClassic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * VanillaClassic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
/*
 * This file is part of Vanilla.
 *
 * Copyright (c) 2011-2012, Spout LLC <http://www.spout.org/>
 * Vanilla is licensed under the Spout License Version 1.
 *
 * Vanilla is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the Spout License Version 1.
 *
 * Vanilla is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the Spout License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://spout.in/licensev1> for the full license, including
 * the MIT license.
 */
package com.greatmancode.vanillaclassic.chat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import gnu.trove.map.TCharObjectMap;
import gnu.trove.map.hash.TCharObjectHashMap;

import org.spout.api.chat.ChatArguments;
import org.spout.api.chat.style.ChatStyle;
import org.spout.api.chat.style.StyleFormatter;
import org.spout.api.chat.style.StyleHandler;

/**
 * A Vanilla implementation of chat styles
 */
public class VanillaClassicStyleHandler extends StyleHandler {
    private static final TCharObjectMap<ChatStyle> BY_CHAR = new TCharObjectHashMap<ChatStyle>();
    public static final VanillaClassicStyleHandler INSTANCE = new VanillaClassicStyleHandler();
    public static final int ID = register(INSTANCE);
    private final Pattern stylePattern;
    private final Pattern styleExtractPattern;

    /**
     * Creates a new VanillaStyleHandler and registers the default
     * VanillaClassicStyleFormatters.
     */
    public VanillaClassicStyleHandler() {
        super();
        registerFormatter(ChatStyle.BLACK, new VanillaClassicStyleFormatter('0'));
        registerFormatter(ChatStyle.DARK_BLUE, new VanillaClassicStyleFormatter('1'));
        registerFormatter(ChatStyle.DARK_GREEN, new VanillaClassicStyleFormatter('2'));
        registerFormatter(ChatStyle.DARK_CYAN, new VanillaClassicStyleFormatter('3'));
        registerFormatter(ChatStyle.DARK_RED, new VanillaClassicStyleFormatter('4'));
        registerFormatter(ChatStyle.PURPLE, new VanillaClassicStyleFormatter('5'));
        registerFormatter(ChatStyle.GOLD, new VanillaClassicStyleFormatter('6'));
        registerFormatter(ChatStyle.GRAY, new VanillaClassicStyleFormatter('7'));
        registerFormatter(ChatStyle.DARK_GRAY, new VanillaClassicStyleFormatter('8'));
        registerFormatter(ChatStyle.BLUE, new VanillaClassicStyleFormatter('9'));
        registerFormatter(ChatStyle.BRIGHT_GREEN, new VanillaClassicStyleFormatter('a'));
        registerFormatter(ChatStyle.CYAN, new VanillaClassicStyleFormatter('b'));
        registerFormatter(ChatStyle.RED, new VanillaClassicStyleFormatter('c'));
        registerFormatter(ChatStyle.PINK, new VanillaClassicStyleFormatter('d'));
        registerFormatter(ChatStyle.YELLOW, new VanillaClassicStyleFormatter('e'));
        registerFormatter(ChatStyle.WHITE, new VanillaClassicStyleFormatter('f'));
        registerFormatter(ChatStyle.CONCEAL, new VanillaClassicStyleFormatter('k'));
        registerFormatter(ChatStyle.BOLD, new VanillaClassicStyleFormatter('l'));
        registerFormatter(ChatStyle.STRIKE_THROUGH, new VanillaClassicStyleFormatter('m'));
        registerFormatter(ChatStyle.UNDERLINE, new VanillaClassicStyleFormatter('n'));
        registerFormatter(ChatStyle.ITALIC, new VanillaClassicStyleFormatter('o'));
        registerFormatter(ChatStyle.RESET, new VanillaClassicStyleFormatter('r'));
        StringBuilder stylePatternString = new StringBuilder();
        StringBuilder styleExtractPatternString = new StringBuilder();
        stylePatternString.append("(?i)").append(VanillaClassicStyleFormatter.COLOR_CHAR).append("([");
        styleExtractPatternString.append("(?i)(?:").append(VanillaClassicStyleFormatter.COLOR_CHAR).append("([");
        for (StyleFormatter formatter : getFormatters()) {
            if (formatter instanceof VanillaClassicStyleFormatter) {
                stylePatternString.append(((VanillaClassicStyleFormatter) formatter).getStyleChar());
                styleExtractPatternString.append(((VanillaClassicStyleFormatter) formatter).getStyleChar());
            }
        }

        stylePatternString.append("])");
        styleExtractPatternString.append("]))?([^").append(VanillaClassicStyleFormatter.COLOR_CHAR).append("]+)");
        stylePattern = Pattern.compile(stylePatternString.toString());
        styleExtractPattern = Pattern.compile(styleExtractPatternString.toString());
    }

    /**
     * Registers the passed StyleFormatter on the engine.
     */
    @Override
    public void registerFormatter(ChatStyle style, StyleFormatter formatter) {
        if (formatter instanceof VanillaClassicStyleFormatter) {
            BY_CHAR.put(((VanillaClassicStyleFormatter) formatter).getStyleChar(), style);
        }
        super.registerFormatter(style, formatter);
    }

    /**
     * Gets the StylePattern of the VanillaStyleHandler.
     * @return The StylePattern.
     */
    public Pattern getStylePattern() {
        return stylePattern;
    }

    /**
     * Gets a ChatStyle by a char.
     * @param c The char to get the ChatStyle from.
     * @return The ChatStyle of the passed char.
     */
    public ChatStyle byChar(char c) {
        return BY_CHAR.get(c);
    }

    /**
     * Matches the passed String with the stylePattern of the
     * VanillaStyleHandler<br>
     * and replaces every subsequence with "".
     * @returns The striped String.
     */
    public String stripStyle(String formatted) {
        return stylePattern.matcher(formatted).replaceAll("");
    }

    /**
     * Extracts the ChatStyles from a String.
     * @returns The ChatSyles as ChatArguments.
     */
    public ChatArguments extractArguments(String str) {
        ChatArguments args = new ChatArguments();
        Matcher matcher = styleExtractPattern.matcher(str);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                ChatStyle style = byChar(matcher.group(1).charAt(0));
                if (style == null) {
                    args.append(matcher.group(0));
                    continue;
                }
                args.append(style);
            }
            args.append(matcher.group(2));
        }
        return args;
    }
}