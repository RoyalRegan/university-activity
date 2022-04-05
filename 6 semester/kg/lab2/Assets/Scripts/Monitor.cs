using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Monitor : MonoBehaviour
{
    public GameObject monitor;

    void Update()
    {
       
    }

    void OnTriggerStay(Collider other)
    {
        if (Input.GetKeyDown(KeyCode.E))
        {
            if (monitor.GetComponent<Renderer>().enabled)
            {
                monitor.GetComponent<Renderer>().enabled = false;
            }
            else
            {
                monitor.GetComponent<Renderer>().enabled = true;
            }
        }
    }
}
