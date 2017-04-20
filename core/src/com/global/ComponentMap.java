package com.global;
import com.badlogic.ashley.core.ComponentMapper;
import com.assets.components.group.ComActor;
import com.assets.components.general.ComBbox;
import com.assets.components.general.ComChunk;
import com.assets.components.general.ComFunction;
import com.assets.components.general.ComLabel;
import com.assets.components.general.ComPosition;
import com.assets.components.general.ComSprite;
import com.assets.components.general.ComTimer;
import com.assets.components.general.ComVelocity;
import com.assets.components.group.ComButton;
import com.assets.components.group.ComTextField;

/**
 *
 * @author cohib
 */
public class ComponentMap{
    
    public static final ComponentMapper<ComChunk> CHUNKCOORD = ComponentMapper.getFor(ComChunk.class);
    public static final ComponentMapper<ComButton> BUTTON = ComponentMapper.getFor(ComButton.class);
    public static final ComponentMapper<ComTextField> INPUTBOX = ComponentMapper.getFor(ComTextField.class);
    public static final ComponentMapper<ComTimer> TIMER = ComponentMapper.getFor(ComTimer.class);
    public static final ComponentMapper<ComPosition> POSITION = ComponentMapper.getFor(ComPosition.class);
    public static final ComponentMapper<ComSprite> SPRITE = ComponentMapper.getFor(ComSprite.class);
    public static final ComponentMapper<ComVelocity> VELOCITY = ComponentMapper.getFor(ComVelocity.class);
    public static final ComponentMapper<ComBbox> BBOX = ComponentMapper.getFor(ComBbox.class);
    public static final ComponentMapper<ComLabel> LABEL = ComponentMapper.getFor(ComLabel.class);
    public static final ComponentMapper<ComActor> ACTOR = ComponentMapper.getFor(ComActor.class);
    public static final ComponentMapper<ComFunction> FUNCTION = ComponentMapper.getFor(ComFunction.class);

}