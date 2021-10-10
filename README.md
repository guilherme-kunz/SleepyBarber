# SleepyBarber

## Barber's sleeper problem

Directed study made in Java on the classic barber problem sleeper.
Among several solutions that can be implemented for this problem, in this repository the solution is displayed using the concept of threads.
The barber's sleeper problem consists of:

The barber shop has:

<ul>
<li>A barber</li>
<li>A barber chair</li>
<li>Some chairs for clients wait</li>
</ul>

If the movement is weak (no clients), the barber sits in his chair and sleeps;
When a customer arrives in the empty hall, he has to wake the barber;
If other clients arrive while the barber is busy, they:

<ul>
<li>Sit in the waiting chair</li>
<li>Go away if there is no empty chair</li>
</ul>

## Implementation of the solution

The implementation has a main traffic light that is the abstraction of the barber's chair. 
Each client waits for his turn, is actually a thread that tries to acquire the traffic light. 
Whenever a thread releases the traffic light, a new thread acquires such a traffic light, 
leaving the queue waiting and releasing a vacancy in such a queue.

## Contact

E-mail: guilhermebutzenkunz@gmail.com

Connect with me on [LinkedIn](https://www.linkedin.com/in/guilherme-butzen-kunz-026287202/)

Thanks!
