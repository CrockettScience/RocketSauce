package com.base.global;
import com.badlogic.ashley.core.ComponentMapper;
import com.base.assets.components.componentGroups.ComActor;
import com.base.assets.components.general.ComBbox;
import com.base.assets.components.general.ComFunction;
import com.base.assets.components.general.ComLabel;
import com.base.assets.components.general.ComPosition;
import com.base.assets.components.general.ComSprite;
import com.base.assets.components.general.ComVelocity;

/**
 *
 * @author cohib
 */
public class BaseComponentMap{
    public static final ComponentMapper<ComPosition> POSITION = ComponentMapper.getFor(ComPosition.class);
    public static final ComponentMapper<ComSprite> SPRITE = ComponentMapper.getFor(ComSprite.class);
    public static final ComponentMapper<ComVelocity> VELOCITY = ComponentMapper.getFor(ComVelocity.class);
    public static final ComponentMapper<ComBbox> BBOX = ComponentMapper.getFor(ComBbox.class);
    public static final ComponentMapper<ComLabel> LABEL = ComponentMapper.getFor(ComLabel.class);
    public static final ComponentMapper<ComActor> ACTOR = ComponentMapper.getFor(ComActor.class);
    public static final ComponentMapper<ComFunction> FUNCTION = ComponentMapper.getFor(ComFunction.class);

}