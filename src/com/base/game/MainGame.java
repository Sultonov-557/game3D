package com.base.game;

import com.base.engine.components.MeshRenderer;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Texture;

public class MainGame extends Game {
    @Override
    public void Init() {
        super.Init();

        Setup setup=new Setup();
        AddObject(setup.light);
        AddObject(setup.skyBack);
        AddObject(setup.skyFront);
        AddObject(setup.skyBottom);
        AddObject(setup.skyTop);
        AddObject(setup.skyLeft);
        AddObject(setup.skyRight);
        AddObject(setup.camera);

        GameObject chunk=new GameObject();
        Texture texture=new Texture("sky.jpg");
        chunk.AddComponent(new MeshRenderer(MeshGenerator.Generate(), new Material(texture, 1, 1, texture, texture, 0, 0)));
        AddObject(chunk);
    }
}
