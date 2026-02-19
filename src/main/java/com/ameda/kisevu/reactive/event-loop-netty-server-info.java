/**
 * Author: kev.Ameda
 */
package com.ameda.kisevu.reactive;

//How Netty Server works
/*
*  - Tomcat works with the thread per-request model. Each request is handled by one
*   particular thread, and the thread is entirely responsible to process the user request.
*   If the request has some huge bulk of work to handle then the thread will be blocked
*  - Netty uses an event loop model.
*  - Event loop - This is a server / worker thread but the catch is that, with this thread
*    we are able to serve many requests at a time.
*  - A channel is a connection between the server and the client. It is through the channel that the requests gets to the
*    thread - the event loop.  (a typical tcp connection.). For this to happen the channel registration should be done between
*    the channel and the event loop. The request is converted to a task and the task is processed by the event loop.
*    The task does not go directly to the event loop, the tasks goes to some sort of task queue. The tasks are generally callbacks.
*  -  The queue normally works in a FIFO fashion.
*  -  The blocking I/O calls are off-loaded to the background. Now the blocking I/O is  going to execute your blocking call  and
*    this execution is necessitated by a set of thread pools which are not part of our actual set up. So after completing the blocking call,
*    the blocking i/o will send a request back to the event loop and if the event loop has got no other tasks in the queue scheduled, it will
*    execute or return the response. Otherwise, the completed response from the blocking i/o or the operation is put to the queue and scheduled
*    for execution by the event loop.
*  - This is how the event loop can execute millions of requests because it is not blocking.
*  -  How the event loop remembers who made the call or the request. The webflux works with the callbacks and other mechanisms.
* */