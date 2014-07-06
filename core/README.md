# Factoidstore

Project in development, based on vertx. 

## Aim

Data is a big issue. Data is big, and it's about big data. There is SQL and NoSQL. There's also event sourcing. And there are programming design patterns and architectures. Mapping between databases and domain logic isn't always easy, or pretty damn'd hard in other cases.

So, one day I just thought, why not develop a kind of event store in which CQRS is embedded. So this is it, a first attempt, but in development. There is one scheme, and that scheme contains all information, even the database-specific information. 

## Factoid?

What the hell, factoid? Well, yeah, it's just, the events stored digitally don't need to be 'true' in the sense that they are reality. They are and will always be some kind of virtual truth. The store contains just really small pieces of information that may, or may not be true, but they might, in the end, become accepted as fact, just because they're written in the store - the computer is always right, right? I actually don't care, neither does factoidstore, if the information is factually valid or not. That's why 'factoid' describes the intent better than 'event':

> A factoid is a questionable or spurious (unverified, false, or fabricated) statement presented as a fact, 
> but without supporting evidence, although the term can have conflicting meanings.

from: [wikipedia](http://en.wikipedia.org/wiki/Factoid/ "Factoid")
