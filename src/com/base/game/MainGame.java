package com.base.game;

import com.base.engine.components.MeshRenderer;
import com.base.engine.core.Game;
import com.base.engine.core.GameObject;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Texture;

public class MainGame extends Game {
    @Override
    public void Init() {
        super.Init();

        GameObject chunkObject = new GameObject();
        Texture texture = new Texture("sky.jpg");
        Material chunkMaterial = new Material(texture, 1, 1, texture, texture, 1, 1);
        Chunk chunk = new Chunk(new Vector3f(12, 12, 12));
        MeshRenderer chunkMeshRenderer = new MeshRenderer(chunk.chunkMesh.mesh, chunkMaterial);
        chunkObject.AddComponent(chunkMeshRenderer);

        AddObject(chunkObject);

        Setup setup = new Setup();
        AddObject(setup.camera);
        AddObject(setup.skyBack);
        AddObject(setup.skyBottom);
        AddObject(setup.skyFront);
        AddObject(setup.skyLeft);
        AddObject(setup.skyRight);
        AddObject(setup.skyTop);

    }
}
