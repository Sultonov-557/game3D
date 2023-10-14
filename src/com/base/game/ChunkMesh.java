package com.base.game;

import java.util.ArrayList;
import java.util.List;

import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Vertex;

public class ChunkMesh {

    private List<Vertex> vertices;
    private List<Integer> triangles;
    private int index = 0;
    public Mesh mesh;

    public ChunkMesh(Voxel[][][] voxelMap, Vector3f size) {
        vertices = new ArrayList<Vertex>();
        triangles = new ArrayList<Integer>();

        for (int x = 0; x < voxelMap.length; x++) {
            for (int y = 0; y < voxelMap[x].length; y++) {
                for (int z = 0; z < voxelMap[x][y].length; z++) {
                    Voxel voxel = voxelMap[x][y][z];
                    if (voxel.ID == 1) {
                        AddSide("y+", new Vector3f(x, y, z));
                        AddSide("y-", new Vector3f(x, y, z));
                        AddSide("x+", new Vector3f(x, y, z));
                        AddSide("x-", new Vector3f(x, y, z));
                        AddSide("z+", new Vector3f(x, y, z));
                        AddSide("z-", new Vector3f(x, y, z));
                    }
                }
            }
        }

        mesh = new Mesh(vertices.toArray(new Vertex[0]), triangles.stream().mapToInt(i -> i).toArray(), true);
    }

    public void AddSide(String side, Vector3f position) {
        if (side == "y+") {
            vertices.add(new Vertex(position.Add(new Vector3f(0, 1, 0))));// 0
            vertices.add(new Vertex(position.Add(new Vector3f(1, 1, 0))));// 1
            vertices.add(new Vertex(position.Add(new Vector3f(0, 1, 1))));// 2
            vertices.add(new Vertex(position.Add(new Vector3f(1, 1, 1))));// 3

            triangles.add(2 + index);
            triangles.add(1 + index);
            triangles.add(0 + index);
            triangles.add(2 + index);
            triangles.add(3 + index);
            triangles.add(1 + index);
            index += 4;
        }
        if (side == "y-") {
            vertices.add(new Vertex(position.Add(new Vector3f(0, 0, 0))));// 0
            vertices.add(new Vertex(position.Add(new Vector3f(1, 0, 0))));// 1
            vertices.add(new Vertex(position.Add(new Vector3f(0, 0, 1))));// 2
            vertices.add(new Vertex(position.Add(new Vector3f(1, 0, 1))));// 3

            triangles.add(0 + index);
            triangles.add(1 + index);
            triangles.add(2 + index);
            triangles.add(1 + index);
            triangles.add(3 + index);
            triangles.add(2 + index);
            index += 4;
        }
        if (side == "x+") {
            vertices.add(new Vertex(position.Add(new Vector3f(1, 0, 0))));// 0
            vertices.add(new Vertex(position.Add(new Vector3f(1, 1, 0))));// 1
            vertices.add(new Vertex(position.Add(new Vector3f(1, 0, 1))));// 2
            vertices.add(new Vertex(position.Add(new Vector3f(1, 1, 1))));// 3

            triangles.add(0 + index);
            triangles.add(1 + index);
            triangles.add(2 + index);
            triangles.add(3 + index);
            triangles.add(2 + index);
            triangles.add(1 + index);
            index += 4;
        }
        if (side == "x-") {
            vertices.add(new Vertex(position.Add(new Vector3f(0, 0, 0))));// 0
            vertices.add(new Vertex(position.Add(new Vector3f(0, 1, 0))));// 1
            vertices.add(new Vertex(position.Add(new Vector3f(0, 0, 1))));// 2
            vertices.add(new Vertex(position.Add(new Vector3f(0, 1, 1))));// 3

            triangles.add(2 + index);
            triangles.add(1 + index);
            triangles.add(0 + index);
            triangles.add(1 + index);
            triangles.add(2 + index);
            triangles.add(3 + index);
            index += 4;
        }
        if (side == "z+") {
            vertices.add(new Vertex(position.Add(new Vector3f(0, 0, 1))));// 0
            vertices.add(new Vertex(position.Add(new Vector3f(1, 0, 1))));// 1
            vertices.add(new Vertex(position.Add(new Vector3f(0, 1, 1))));// 2
            vertices.add(new Vertex(position.Add(new Vector3f(1, 1, 1))));// 3

            triangles.add(0 + index);
            triangles.add(1 + index);
            triangles.add(2 + index);
            triangles.add(3 + index);
            triangles.add(2 + index);
            triangles.add(1 + index);
            index += 4;
        }
        if (side == "z-") {
            vertices.add(new Vertex(position.Add(new Vector3f(0, 0, 0))));// 0
            vertices.add(new Vertex(position.Add(new Vector3f(1, 0, 0))));// 1
            vertices.add(new Vertex(position.Add(new Vector3f(0, 1, 0))));// 2
            vertices.add(new Vertex(position.Add(new Vector3f(1, 1, 0))));// 3

            triangles.add(2 + index);
            triangles.add(1 + index);
            triangles.add(0 + index);
            triangles.add(1 + index);
            triangles.add(2 + index);
            triangles.add(3 + index);
            index += 4;
        }
    }
}
