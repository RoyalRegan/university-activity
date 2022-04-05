using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MoveByKey : MonoBehaviour
{
    public List<GameObject> gameObjects;
    public KeyCode keyCode;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(keyCode))
        {
            gameObjects.ForEach((it)=> it.GetComponent<Rigidbody>().AddForce(-40, 200, 0));
        }
    }
}
