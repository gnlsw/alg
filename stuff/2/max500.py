def add_record(record):
    print record

class Record:
    def __init__(self, time):
        self.time = time
        self.count = 1

    def same_time(self, time):
        if self.time == time:
            return True
        else:
            return False

    def count_plus_one():
        self.count += 1

    def __str__(self):
        return 'time is {0}, count is {1}'.format(self.time, self.count)


if __name__ == "__main__":
    fp_in = open("trade.log", 'r')

    # read first line
    first_line = fp_in.readline()
    current_time = first_line.split(",")[0]
    current_record = Record(current_time)

    for eachline in fp_in:
        next_time = eachline.split(",")[0]
        if current_record.same_time(next_time):
            current_record.count_plus_one()
        else:
            add_record(current_record)
            current_record = Record(next_time)

    add_record(current_record)
