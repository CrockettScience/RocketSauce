package com.global;
import com.badlogic.ashley.core.ComponentMapper;
import com.assets.components.group.ComActor;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComDraw;
import com.assets.components.general.ComScript;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSound;
import com.assets.components.general.ComSprite;
import com.assets.components.general.ComTimer;
import com.assets.components.general.ComVelocity;
import com.assets.components.group.ComButton;
import com.assets.components.group.ComTextField;

/**
 *
 * @author Jonathan Crockett
 */
public class ComponentMap{
    
    public static final ComponentMapper<ComButton> BUTTON = ComponentMapper.getFor(ComButton.class);
    public static final ComponentMapper<ComTextField> INPUTBOX = ComponentMapper.getFor(ComTextField.class);
    public static final ComponentMapper<ComTimer> TIMER = ComponentMapper.getFor(ComTimer.class);
    public static final ComponentMapper<ComPosition> POSITION = ComponentMapper.getFor(ComPosition.class);
    public static final ComponentMapper<ComSprite> SPRITE = ComponentMapper.getFor(ComSprite.class);
    public static final ComponentMapper<ComVelocity> VELOCITY = ComponentMapper.getFor(ComVelocity.class);
    public static final ComponentMapper<ComBbox> BBOX = ComponentMapper.getFor(ComBbox.class);
    public static final ComponentMapper<ComLabel> LABEL = ComponentMapper.getFor(ComLabel.class);
    public static final ComponentMapper<ComActor> ACTOR = ComponentMapper.getFor(ComActor.class);
    public static final ComponentMapper<ComScript> SCRIPT = ComponentMapper.getFor(ComScript.class);
    public static final ComponentMapper<ComSound> SOUND = ComponentMapper.getFor(ComSound.class);
    public static final ComponentMapper<ComDraw> DRAW = ComponentMapper.getFor(ComDraw.class);

}