using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class LightsSwitcher : MonoBehaviour
{
    public Light light;

    void Update()
    {
        
    }

    private void OnTriggerStay(Collider other)
    {
        if (Input.GetKeyDown(KeyCode.E))
        {
            light.enabled = !light.enabled;
        }

    }
}
