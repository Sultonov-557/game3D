package com.base.game;

import com.base.engine.components.Camera;
import com.base.engine.components.FreeLook;
import com.base.engine.components.FreeMove;
import com.base.engine.components.MeshRenderer;
import com.base.engine.components.PointLight;
import com.base.engine.core.GameObject;
import com.base.engine.core.Matrix4f;
import com.base.engine.core.Quaternion;
import com.base.engine.core.Vector3f;
import com.base.engine.rendering.Attenuation;
import com.base.engine.rendering.Material;
import com.base.engine.rendering.Mesh;
import com.base.engine.rendering.Texture;
import com.base.engine.rendering.Window;

public class Setup {

    public GameObject skyBottom=new GameObject();
    public GameObject skyTop=new GameObject();
    public GameObject skyBack=new GameObject();
    public GameObject skyFront=new GameObject();
    public GameObject skyLeft=new GameObject();
    public GameObject skyRight=new GameObject();
    public GameObject light=new GameObject();
    public GameObject camera=new GameObject();

    public Setup(){
        Material material = new Material(new Texture("sky.jpg"), 10, 1, new Texture("sky.jpg"), new Texture("sky.jpg"), 0, 0);
        Mesh mesh=new Mesh("plane3.obj");
        
        skyBottom.AddComponent(new MeshRenderer(mesh, material));
        skyBottom.GetTransform().GetPos().Set(0,-100,0);
        skyBottom.GetTransform().GetScale().Set(100,1,100);
        
        skyTop.AddComponent(new MeshRenderer(mesh, material));
        skyTop.GetTransform().GetPos().Set(0,100,0);
        skyTop.GetTransform().GetScale().Set(100,1,100);
        
        skyBack.AddComponent(new MeshRenderer(mesh, material));
        skyBack.GetTransform().GetPos().Set(0,0,-100);
        skyBack.GetTransform().GetScale().Set(100,1,100);
        skyBack.GetTransform().GetRot().Set(new Quaternion(new Vector3f(1,0,0), (float)Math.toRadians(90)));
        
        skyFront.AddComponent(new MeshRenderer(mesh, material));
        skyFront.GetTransform().GetPos().Set(0,0,100);
        skyFront.GetTransform().GetScale().Set(100,1,100);
        skyFront.GetTransform().GetRot().Set(new Quaternion(new Vector3f(1,0,0), (float)Math.toRadians(-90)));

        skyLeft.AddComponent(new MeshRenderer(mesh, material));
        skyLeft.GetTransform().GetPos().Set(-100,0,0); 
        skyLeft.GetTransform().GetScale().Set(100,1,100);
        skyLeft.GetTransform().GetRot().Set(new Quaternion(new Vector3f(0,0,1), (float)Math.toRadians(-90)));
        
        skyRight.AddComponent(new MeshRenderer(mesh, material));
        skyRight.GetTransform().GetPos().Set(100,0,0); 
        skyRight.GetTransform().GetScale().Set(100,1,100);
        skyRight.GetTransform().GetRot().Set(new Quaternion(new Vector3f(0,0,1), (float)Math.toRadians(-90)));
        
        PointLight lightC=new PointLight(new Vector3f(1, 1, 1), 1, new Attenuation(1, 1, 0));
        light.AddComponent(lightC);

        camera.AddComponent(new FreeLook(0.5f)).AddComponent(new FreeMove(10.0f))
						.AddComponent(new Camera(new Matrix4f().InitPerspective((float) Math.toRadians(70.0f),
								(float) Window.GetWidth() / (float) Window.GetHeight(), 0.01f, 1000.0f)));
    }
}
