using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OnHitAudioScript : MonoBehaviour
{
    public AudioSource soundEff;
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    private void OnCollisionEnter(Collision collision)
    {
        soundEff.Play();
    }
}
