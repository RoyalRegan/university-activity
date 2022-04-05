using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Door : MonoBehaviour
{
    private Animator animator;

    void Start()
    {
        animator = GetComponent<Animator>();
    }

    void OnTriggerStay(Collider other)
    {
        if (Input.GetKeyDown(KeyCode.E))
        {
            if (animator.GetBool("state"))
            {
                animator.SetBool("state", false);
            }
            else
            {
                animator.SetBool("state", true);
            }

        }
    }
}
