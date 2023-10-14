package com.base.game;

import com.base.engine.core.Vector3f;

public class Chunk {
    public VoxelMap voxelMap;
    public ChunkMesh chunkMesh;

    public Chunk(Vector3f size) {
        voxelMap = new VoxelMap(size);
        chunkMesh = new ChunkMesh(voxelMap.voxelMap, size);
    }
}
