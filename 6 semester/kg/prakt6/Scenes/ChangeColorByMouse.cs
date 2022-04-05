using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ChangeColorByMouse : MonoBehaviour
{
    public Renderer render;
    // Start is called before the first frame update
    void Start()
    {
        render = GetComponent<Renderer>();
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnMouseEnter()
    {
        render.material.color = Color.cyan;
    }

    private void OnMouseExit()
    {
        render.material.color = Color.black;
    }
}
