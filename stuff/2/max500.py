def add_record(time, count):
    print "add record" 
    print time
    print count


if __name__ == "__main__":
    fp_in = open("trade.log", 'r')

    # read first line
    first_line = fp_in.readline()
    current_time = first_line.split(",")[0]
    count = 1

    for eachline in fp_in:
        next_time = eachline.split(",")[0]
        if next_time == current_time:
            count = count + 1
        else:
            add_record(current_time, count)
            current_time = next_time
            count = 1

    add_record(current_time, count)
