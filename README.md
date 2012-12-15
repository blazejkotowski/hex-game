hex-game
========

http://www.di.fc.ul.pt/~jpn/gv/hex.htm

```
              .
             / \
            |   |
           / \ / \
          |   |   |
         / \ / \ / \
        |   | □ |   |
       / \ / \ / \ / \
      |   |   |   |   |
     / \ / \ / \ / \ / \
    |   | ■ |   | □ |   |
   / \ / \ / \ / \ / \ / \
  |   |   |   |   |   |   |
   \ / \ / \ / \ / \ / \ /
    |   |   | ■ |   |   |
     \ / \ / \ / \ / \ /
      |   | □ |   |   |
       \ / \ / \ / \ /
        |   |   |   |
         \ / \ / \ /
          | ■ |   |
           \ / \ /
            |   |
             \ /
              '
```

## building

Use apache ant (http://ant.apache.org/):

```
sudo apt-get install ant
```

To compile & run:
```
ant
```

Just to compile:
```
ant compile
```

## test suite

Use jUnit (https://github.com/kentbeck/junit/wiki):

Write tests in `test/`. To run use:

```
ant test
```

## authors

* Tomasz Pewiński
* Michal Żelazkiewicz
* Michal Mazurek
