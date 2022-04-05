using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BindCube : MonoBehaviour
{
    private Vector3 mouseOffset;
    private float mouseZCoord;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private Vector3 getMousePosition()
    {
        Vector3 mousePoint = Input.mousePosition;
        mousePoint.z = mouseZCoord;
        return Camera.main.ScreenToWorldPoint(mousePoint);
    }

    private void OnMouseDown()
    {
        mouseZCoord = Camera.main.WorldToScreenPoint(gameObject.transform.position).z;
        mouseOffset = gameObject.transform.position - getMousePosition();
    }

    private void OnMouseDrag()
    {
        transform.position = getMousePosition() + mouseOffset;
    }
}
