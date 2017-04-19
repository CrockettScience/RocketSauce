/*
 * Copyright (C) 2017 Jonathan Crockett
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rocketsauce.global;

import com.rocketsauce.assets.components.general.ComTimer;
import com.rocketsauce.assets.components.general.ComChunk;
import com.badlogic.ashley.core.ComponentMapper;
import com.rocketsauce.assets.components.componentGroups.ComButton;
import com.rocketsauce.assets.components.componentGroups.ComTextField;

public class ComponentMap {
    
    public static final ComponentMapper<ComChunk> CHUNKCOORD = ComponentMapper.getFor(ComChunk.class);
    public static final ComponentMapper<ComButton> BUTTON = ComponentMapper.getFor(ComButton.class);
    public static final ComponentMapper<ComTextField> INPUTBOX = ComponentMapper.getFor(ComTextField.class);
    public static final ComponentMapper<ComTimer> TIMER = ComponentMapper.getFor(ComTimer.class);
}
