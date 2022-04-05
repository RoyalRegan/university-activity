using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SceneChangeScript : MonoBehaviour
{
    // Start is called before the first frame update
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.E))
        {
           if (Application.loadedLevelName == "Scene1")
            {
                Application.LoadLevel("Scene2");
            }
           else
            {
                Application.LoadLevel("Scene1");
            }
        }
    }
}
