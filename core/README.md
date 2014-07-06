# Factoidstore

Project in development, based on vertx. 

## Aim

Data is a big issue. Data is big, and it's about big data. There is SQL and NoSQL. There's also event sourcing. And there are programming design patterns and architectures. Mapping between databases, architectures and domain logic isn't always easy, or pretty damn'd hard in other cases. So, some pretty smart guys came up with things like CQRS and DDD. I like the idea, but these concepts are not really easy to implement using common databases.

So, one day I just thought, why not develop a kind of event store in which CQRS is embedded. So this is it, a first attempt, but still in development, probably for a long time. There's the aim, that's a start.

## Factoid?

What the hell, factoid? Well, yeah, it's just, the events stored digitally don't need to be 'true' in the sense that they are reality. They are and will always be some kind of virtual truth. The store contains just really small pieces of information that may, or may not be true, but they might, in the end, become accepted as fact, just because they're written in the store - the computer is always right, right? I actually don't care, neither does factoidstore, if the information is factually valid or not. That's why 'factoid' describes the intent better than 'event':

> A factoid is a questionable or spurious (unverified, false, or fabricated) statement presented as a fact, 
> but without supporting evidence, although the term can have conflicting meanings.

from: [wikipedia](http://en.wikipedia.org/wiki/Factoid "Factoid")


## How does it work?

1. You shall have no other schemes before The Scheme.
2. You shall not make idols of The Scheme.
3. You shall not take the name of The Scheme in vain.

Get it? There's only one scheme, and one scheme only. There is one scheme, and that scheme contains all information, even the database-specific information. The description of attributes must be added to the god-scheme. That scheme has four columns. Nothing new here. Other event based stores have the same, or some pretty similar structure:
1. entity
2. attribute
3. value
4. timestamp

It starts with 1 attribute, the root attribute, and conceptually, it looks like this:
0   attribute:name    attribute:name  [timestamp]

And from here, it's possible to add all kinds of stuff in there. Usually, one should start adding stuff like a description of attributes, attribute-types, validators, ... .
