package com.assets.components.general;

import com.assets.scripts.arguments.ArgsDraw;
import com.badlogic.ashley.core.Component;
import com.util.script.Script;

/**
 *
 * @author Jonathan Crockett
 */
public class ComDraw implements Component{
    private Script<ArgsDraw, ?> preDraw;
    private Script<ArgsDraw, ?> Draw;
    private Script<ArgsDraw, ?> postDraw;

    public Script<ArgsDraw, ?> getPreDraw() {
        return preDraw;
    }

    public Script<ArgsDraw, ?> getPostDraw() {
        return postDraw;
    }

    public void setPreDraw(Script<ArgsDraw, ?> pDraw) {
        preDraw = pDraw;
    }

    public void setPostDraw(Script<ArgsDraw, ?> poDraw) {
        postDraw = poDraw;
    }

    public Script<ArgsDraw, ?> getDraw() {
        return Draw;
    }

    public void setDraw(Script<ArgsDraw, ?> Draw) {
        this.Draw = Draw;
    }
}
